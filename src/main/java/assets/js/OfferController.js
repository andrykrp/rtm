OfferController = $.extend({
    save: function(producerId) {
        console.log(producerId);
        $.ajax({
            url: '/user/' + producerId + '/offer/create',
            type: 'POST',
            contentType: 'application/json',
            data: this.prepareSaveData(),
            success: function (message, status, xhr) {
                //self.showErrorMessageOrRedirectTo(message, "/admin/domain/list");
            },
            error: function (message) {
                //self.showErrorMessage(message.responseJSON.error);
            }
        });
    }
}, BaseController);