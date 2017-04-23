$.fn.initTagsInput = function(arg1, arg2) {  
  
    // bootstrap-tagsinput ���������  
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
  
    // ��������  
    var opt2 = $.extend({  
        'modalAdd': '#modal-add', //���tag��ģ̬��  
        'modalChange': '#modal-change', //�޸�tag��ģ̬��  
        'btnAdd': '#btn-add', //���tag��ģ̬���ȷ����ť  
        'btnChange': '#btn-change', //�޸�tag��ģ̬���ȷ����ť  
        'display': 'block', //tag ������display����  
        'tagStyle': { // tag ����ʽ  
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
    var tagsContainer = tagsinput.$container; // tag ������  
    tagsContainer.css('display', opt2.display);  
  
    var modalAdd = $(opt2.modalAdd); //��� tag ʱ����ʾ��ģ̬��  
    var modalChange = $(opt2.modalChange); //�޸� tag ʱ����ʾ��ģ̬��  
  
    // ���tagsinput�������ʾģ̬��  
    tagsContainer.on('click', function() {  
        $(this).find('input').blur();  
  
        // ���ԭ�������ݣ������� ����tag��ģ̬��  
        modalAdd.find('input').val('');  
        modalAdd.find('textarea').val('');  
        modalAdd.modal('show');  
    });  
  
  
    // ���tag��ģ̬���ȷ�ϰ�ť  
    $(opt2.btnAdd).on('click', function() {  
        var minput = modalAdd.find('input').val();  
        var mtextarea = modalAdd.find('textarea').val();  
  
        if(minput == '' || mtextarea =='') {  
            return false;  
        }  
  
        input.tagsinput('add', {'title' : minput, 'text' : mtextarea});  
  
        modalAdd.modal('hide');  
  
        // ��ǰ�´����ı�ǩ  
        var cur = $(tagsContainer.children('span.tag:last'));  
        cur.css(opt2.tagStyle); //����tag����ʽ  
        cur.on('click', function(e) {  
            e.stopPropagation();  
            tagsContainer.find('input').blur();  
  
            // ��ʾģ̬��  
            var item = $(this).data('item');  
            var title = item.title;  
            var text = item.text;  
  
            modalChange.data('tag', $(this));  
            modalChange.find('input').val(title);  
            modalChange.find('textarea').val(text);  
            modalChange.modal('show');  
        });  
  
  
        // ��ǰ�½��ı�ǩ��ɾ���¼�  
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
  
        // ��ǰ���ڱ༭�� tag  
        var tag = modalChange.data('tag');  
        var beforeTitle = tag.data('item').title;  
        tag.data('item', {title: title, text: text});  
  
        // �޸� tagsArray �б��������  
        for(var i = 0; i < tagsArray.length; i++) {  
            if(tagsArray[i].title == beforeTitle) {  
                tagsArray[i].title = title;  
                tagsArray[i].text = text;  
            }  
        }  
  
        input.tagsinput('pushVal');  
        input.tagsinput('refresh'); //��ˢ�½��桱  
  
        modalChange.modal('hide');  
    });  
};  
