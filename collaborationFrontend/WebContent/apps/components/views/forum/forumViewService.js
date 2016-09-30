var forumService=angular.module('controllerForumViewService',[]);
forumService.factory('ForumViewService', ['$http','$q', function($http,$q){
	var REST_SERVICE_URI='http://localhost:8080/collaborationBackend/forums/forumView/';

	var factory={
		fetchSingleForum: fetchSingleForum,
		fetchAllPost:fetchAllPost,
		createPost:createPost,
		deletePost:deletePost
		/*,
		createForum:createForum,
		updateForum:updateForum,
		deleteForum:deleteForum*/
	};
	return factory;

	function fetchSingleForum(forum_id){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI+forum_id)
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
	function fetchAllPost(){
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
	function createPost(forumView,forumPost){
		var deferred = $q.defer();
		var fv={forum:forumView,forumPost:forumPost}
		$http.post(REST_SERVICE_URI,fv)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while creating forumView');
				deferred.reject(errResponse);
			}
			);
		return deferred.promise;
	}
	function deletePost(forumPost_id){
		var deferred=$q.defer();
		$http.delete(REST_SERVICE_URI+forumPost_id)
		.then(
			function(response){
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.log('error while delete the forumPost');
				deferred.reject(errResponse)
			}
			);
		return deferred.promise;
	}
}]);