'use strict';

angularApp
    .controller('successController', function ($scope, Pets) {

        $scope.successMsg = '';
        $scope.Pets = [];

        $scope.initialize = function () {
            $scope.successMsg = "You've logged in!";
            Pets.get().then(function (pets) {
                $scope.Pets = pets.data['pets'];
            });
        };

        $scope.initialize();
    });
