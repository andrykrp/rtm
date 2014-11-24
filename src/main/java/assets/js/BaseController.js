BaseController = {
    prepareSaveData: function () {
        var disabledFields = $('form').find(':input:disabled').removeAttr('disabled');
        var obj = $('form').serializeObject();
        //remove filed of editor
        delete obj["_wysihtml5_mode"];
        var saveData = JSON.stringify(obj);
        disabledFields.attr('disabled', 'disabled');
        return saveData;
    },
    validate: function(validationOptions) {
        var validator = $('form').validate(validationOptions);
        return validator.form();
    },
    showErrorMessageOrRedirectTo: function(data, url) {
        if (data != null && data.length > 0) {
            var message = "";
            for (var i = 0; i < data.length; i++) {
                var field = data[i];
                message += field.message + " </br>";
            }
            this.showErrorMessage(message);
        } else {
            window.location.replace(url);
        }
    },
    showErrorMessage: function(message) {
        bootbox.alert(message);
    },
    showInfoMessage: function(message) {
        bootbox.alert(message);
    },
    isNumeric: function(input) {
        return (input - 0) == input && (''+input).replace(/^\s+|\s+$/g, "").length > 0;
    },
    getHrefByContext: function(context) {
        return "http://" + location.host + "/" + context.replace(/^\//, '');
    }
};