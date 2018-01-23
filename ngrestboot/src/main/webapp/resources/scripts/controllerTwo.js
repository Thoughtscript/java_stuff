angularApp
    .controller('responseBody', function ($scope, Form) {
        $scope.response = "RESPONSEBODY WILL SHOW HERE";
        $scope.postForm = function (context) {
            var userField = document.getElementById('responseBodyUserField'),
                passwordField = document.getElementById('responseBodyPasswordField');
            if (userField.value != '' && passwordField.value != '') {
                Form.post(context, userField.value,
                    passwordField.value, '/post/response/').then(function (v) {
                    $scope.response = v;
                });
            }
        };
    });