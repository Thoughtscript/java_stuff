angularApp
    .controller('requestBody', function ($scope, Form) {
        $scope.postForm = function (context) {
            var userField = document.getElementById('requestBodyUserField'),
                passwordField = document.getElementById('requestBodyPasswordField');
            if (userField.value != '' && passwordField.value != '') {
                Form.post(context, userField.value,
                    passwordField.value, '/post/request/').then(function (v) {
                });
            }
        };
    });

