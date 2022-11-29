$('#confirm-password').on('input', function (e) {
    var pass = $('#password').val();
    var confirm = $("#confirm-password").val();

    if (confirm != pass) {
        $("#error-alert").text("Vui lòng nhập khớp mật khẩu")
        $("#success-alert").text("")
    } else {
        $("#success-alert").text("Mật khẩu khớp")
        $("#error-alert").text("")
    }
})

$('register-form').submit(function(e){
    e.preventDefault();
    var pass = $('#password').val();
    var confirm = $("#confirm-password").val();
    if(confirm != pass) {
        $('#alert-register').text('Vui lòng kiểm tra lại thông tin')
    }else{
        var form = $(this)
        $.ajax({
            method:'POST',
            url:'register',
            data:form.serialize(),
            success: function(data){
                window.location.replace("http://stackoverflow.com");
            }
        })
    }
   
})
$(".product-select").on('change', function (e) {
    var select_val = $(this).find(":selected").val();
    var info = select_val.split('-');
    $(this).closest('.box').find(".plan-price").text(info[1])
    switch (parseInt(info[0])) {
        case 1:
        case 2:
        case 3:
            $('#chi-nha-khoa').find('.summary-text').text(info[1]);
            break;
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
            $('#ban-chay').find('.summary-text').text(info[1]);
            break;
        case 13:
        case 14:
        case 15:
        case 16:
            $('#kem-danh-rang').find('.summary-text').text(info[1]);
            break;
    }
    updateTotal();
})
$("#quantity").on('change', function (e) {
    var quantity = $('#quantity').val()
    if (quantity > 0) {
        $('#quantity-total').text(quantity)
    }
    else
        $('#quantity').val(1);
    updateTotal()

})
function updateTotal() {
    var total = 0
    var price1 = parseInt($("#price-1").text());
    var price2 = parseInt($("#price-2").text());
    var price3 = parseInt($("#price-3").text());
    var quantity = parseInt($('#quantity-total').text())
    //cal new amount and update
    total = (price1 + price2 + price3) * quantity
    $('#total').text(total)
}
$("#checkout").on('click', function (e) {
    var price1 = parseInt($("#price-1").text());
    var price2 = parseInt($("#price-2").text());
    var price3 = parseInt($("#price-3").text());
    if (price1 == 0 || price2 == 0 || price3 == 0) {
        alert("Hình như bạn chọn thiếu 1 doanh mục nào đó :3")
    }else{
        window.location.replace("/dat-hang-thanh-cong")
        var product_1 = $("#doanh-muc-1").find(":selected").val().split('-');
        var product_2 = $("#doanh-muc-2").find(":selected").val().split('-');
        var product_3 = $("#doanh-muc-3").find(":selected").val().split('-');
        var quantity = parseInt($('#quantity-total').text())
        $.ajax({
            url:'checkout-order',
            method:'post',
            data:{
                productId1: product_1[0],
                productId2: product_2[0],
                productId3: product_3[0],
                quantity:quantity,
            },
            error:function(e){
                alert("Hệ thống xảy ra lỗi !")
            }
        })
    }

})