var bSS=angular.module('controllerBlogViewService',[]);
bSS.factory('BlogViewService', ['$http','$q', function($http,$q){
	var REST_SERVICE_URI='http://localhost:8080/collaborationBackend//blogs/blogView/';

	var factory={
		fetchSingleBlog: fetchSingleBlog,
		fetchAllComment:fetchAllComment,
		createComment:createComment,
		deleteComment:deleteComment
		
	};
	return factory;

	function fetchSingleBlog(blog_id){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI+blog_id)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while fetching Events');
				deferred.reject(errResponse);
			}
			);
		return deferred.promise;
	}
	function fetchAllComment(){
		var deferred=$q.defer();
		$http.get(REST_SERVICE_URI)
		.then(
			function(response){
				deferred.resolve(response.data);
		},
		function(errResponse){
			console.error('error while fetching post');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	function createComment(blogView,blog_comments){
		var deferred = $q.defer();
		var fv={blog:blogView,blog_comments:blog_comments}
		$http.post(REST_SERVICE_URI,fv)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while creating blogView');
				deferred.reject(errResponse);
			}
			);
		return deferred.promise;
	}
	function deleteComment(blogComment_id){
        var deferred=$q.defer();
        $http.delete(REST_SERVICE_URI+blogComment_id)
        .then(
            function(response){
            deferred.resolve(response.data);
        },
        function(errResponse){
            console.log('error while delete the blog_comments');
            deferred.reject(errResponse)
        }
        );
       return deferred.promise;
    }
}]);