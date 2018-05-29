/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(single_news)
{
    var id = $("<h3>").html(single_news.id);
    var titolo = $("<h1>").html(single_news.titolo);
    var contenuto = $("<p>").html(single_news.content);
    
    return $("<div>").attr("class", "news").append(id).append(titolo).append(contenuto);
}


function showNews(news){
    var news_div = $("#newsList");
    
    $(news_div).empty();
    for(var instance in news){
        $(news_div).append(createElement(news[instance]));
    }
}

$(document).ready(function () {
    $("#search").click(function () {
        //
        //alert("Hai cliccato sulla search");
    });
    $("#search").keyup(function (){
        $.ajax({
            url: "SearchNews",
            data: {
                cmd: "search",
                query: $("#search").val()
            },
            dataType: 'json',
            success: function (data, state) {
                showNews(data);
            },
            error: function (data, state) {
            } });
        
        var query =  $("#search").val();
        console.log(query);
    });
    
})
