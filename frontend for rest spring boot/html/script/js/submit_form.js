function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
function processForm( e){
    $.ajax({
        url: e.data.url,
        dataType: 'json',
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(getFormData($(this))),
        success: function( data, textStatus, jQxhr ){
            //$('#response pre').html( data );
            console.log(jQxhr);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log( errorThrown );
        }
    });

    e.preventDefault();
}