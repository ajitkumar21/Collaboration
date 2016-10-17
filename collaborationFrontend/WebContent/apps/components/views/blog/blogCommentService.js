var blogCommentService=angular.module('controllerAppBlogCommentService',[]);
blogCommentService.factory('BlogCommentService', ['$http','$q', function($http,$q){
var REST_SERVICE_URI ='http://localhost:8080/collaborationBackend/blogComments/';
	var factory = {
		fetchAllBlogComment: fetchAllBlogComment,
        createBlogComment:createBlogComment
	};
return factory;
   function fetchAllBlogComment(){
   	var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching blogComment');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
   }
 function createBlogComment(blogComment){
 var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, blogComment)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating blogComment');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);