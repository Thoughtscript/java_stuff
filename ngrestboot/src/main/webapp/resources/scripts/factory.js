angularApp
    .factory('Form', function ($http, $q) {
        return {
            post: function (context, username, password, url) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: context + url,
                    headers: {'Content-Type': 'application/json; charset=utf-8'},
                    data: {username: username, password: password}
                }).then(function (response) {
                    deferred.resolve(response);
                });
                return deferred.promise;
            }
        }
    });