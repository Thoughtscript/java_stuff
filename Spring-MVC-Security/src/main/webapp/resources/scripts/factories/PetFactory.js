'use strict';

angularApp
    .factory('Pets', function ($http, $q) {
        return {
            get: function () {
                var deferred = $q.defer(),
                    url = '/springmvcsecurity/secured/pet/all';

                $http.get(url).then(function (response) {
                    deferred.resolve(response);
                });
                return deferred.promise;
            }
        }
    });