$.fn.initTagsInput = function(arg1, arg2) {  
  
    // bootstrap-tagsinput 插件的配置  
    var opt1 = $.extend({  
        trimValue: true,  
        itemValue: function(item) {  
            return item.title;  
        },  
        tagClass: function(item) {  
            var type = 'label-default';  
            switch (parseInt(Math.random() * 6)) {  
                case 0:  
                    type = 'label-default'; break;  
                case 1:  
                    type = 'label-primary'; break;  
                case 2:  
                    type = 'label-success'; break;  
                case 3:  
                    type = 'label-info'; break;  
                case 4:  
                    type = 'label-warning'; break;  
                case 5:  
                    type = 'label-danger'; break;  
            }  
            return 'label ' + type;  
        }  
    }, arg1);  
  
    // 基本配置  
    var opt2 = $.extend({  
        'modalAdd': '#modal-add', //添加tag的模态框  
        'modalChange': '#modal-change', //修改tag的模态框  
        'btnAdd': '#btn-add', //添加tag的模态框的确定按钮  
        'btnChange': '#btn-change', //修改tag的模态框的确定按钮  
        'display': 'block', //tag 容器的display属性  
        'tagStyle': { // tag 的样式  
            'display': 'inline-block',  
            'margin': '0.4em 0',  
            'fontSize': '1.1em',  
            'padding': '0.6em'  
        }  
    }, arg2);  
  
  
    var self = $(this);  
  
    var tagsinput = self.tagsinput(opt1)[0];  
  
    var input = tagsinput.$element;  
    var tagsArray = tagsinput.itemsArray;  
    var tagsContainer = tagsinput.$container; // tag 的容器  
    tagsContainer.css('display', opt2.display);  
  
    var modalAdd = $(opt2.modalAdd); //添加 tag 时，显示的模态框  
    var modalChange = $(opt2.modalChange); //修改 tag 时，显示的模态框  
  
    // 点击tagsinput输入框，显示模态框  
    tagsContainer.on('click', function() {  
        $(this).find('input').blur();  
  
        // 清除原来的内容，打开用于 增加tag的模态框  
        modalAdd.find('input').val('');  
        modalAdd.find('textarea').val('');  
        modalAdd.modal('show');  
    });  
  
  
    // 添加tag的模态框的确认按钮  
    $(opt2.btnAdd).on('click', function() {  
        var minput = modalAdd.find('input').val();  
        var mtextarea = modalAdd.find('textarea').val();  
  
        if(minput == '' || mtextarea =='') {  
            return false;  
        }  
  
        input.tagsinput('add', {'title' : minput, 'text' : mtextarea});  
  
        modalAdd.modal('hide');  
  
        // 当前新创建的标签  
        var cur = $(tagsContainer.children('span.tag:last'));  
        cur.css(opt2.tagStyle); //设置tag的样式  
        cur.on('click', function(e) {  
            e.stopPropagation();  
            tagsContainer.find('input').blur();  
  
            // 显示模态框  
            var item = $(this).data('item');  
            var title = item.title;  
            var text = item.text;  
  
            modalChange.data('tag', $(this));  
            modalChange.find('input').val(title);  
            modalChange.find('textarea').val(text);  
            modalChange.modal('show');  
        });  
  
  
        // 当前新建的标签的删除事件  
        cur.children('span[data-role=remove]').on('click', function(e) {  
            e.stopPropagation();  
            if (tagsinput.$element.attr('disabled')) {  
                return;  
            }  
            tagsinput.remove($(e.target).closest('.tag').data('item'));  
        });  
  
    });  
  
    $(opt2.btnChange).on('click', function() {  
  
        var title = modalChange.find('input').val();  
        var text = modalChange.find('textarea').val();  
  
        // 当前正在编辑的 tag  
        var tag = modalChange.data('tag');  
        var beforeTitle = tag.data('item').title;  
        tag.data('item', {title: title, text: text});  
  
        // 修改 tagsArray 中保存的内容  
        for(var i = 0; i < tagsArray.length; i++) {  
            if(tagsArray[i].title == beforeTitle) {  
                tagsArray[i].title = title;  
                tagsArray[i].text = text;  
            }  
        }  
  
        input.tagsinput('pushVal');  
        input.tagsinput('refresh'); //“刷新界面”  
  
        modalChange.modal('hide');  
    });  
};  
