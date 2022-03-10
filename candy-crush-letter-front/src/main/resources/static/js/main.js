// Hello.
//
// This is The Scripts used for ___________ Theme
//
//

function main() {

(function () {
   'use strict';

    
 	// Smooth Scrolling
    //==========================================
    $(function() {


        $("#doBtn").click(function (e) {
            var str = $("#str").val()
            var num = $("#num").val()
            var url
            var radio = $('input:radio:checked').val()
            console.log("radio:"+radio)
            if(radio == 1){
                url = 'http://localhost:8080/front/duplicates/removeDuplicates/'+str+'/'+num;
            }
            if(radio == 2){
                url = 'http://localhost:8080/front/duplicates/replacedDuplicates/'+str+'/'+num;
            }
            $.ajax({
                url:url,
                type: 'get',                 //获取数据方式:post/get //加载方式默认异步,true为同步
                success:function(data){
                    console.log(data)
                    console.log(data.data)
                    var carNewsList = "";
                    if(data.data){
                        $.each(data.data,function(i,item){   //遍历ul中的li
                            console.log(item)
                            carNewsList += "<li  style='font-size:30px;color:#5d5d5d;'>"+item+"</li>";
                        });
                        $('#u').html(carNewsList);        //数据在<ul id="leftCarInformationList"></ul>里面显示
                        $(".popup").show();
                    }
                },
                error: function(obj){
                    console.log("return error:"+obj);
                },
            });
        })

        $(".closePopup").click(function (e) {
            $(".popup").hide()
        })
 
});

 


}());


}
main();