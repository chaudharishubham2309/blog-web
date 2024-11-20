angular.module('blogApp', [])
  .controller('BlogController', function($scope) {
    var vm = this;
    
    vm.posts = [];
    vm.newPost = {};
    vm.newComment = '';
    
    vm.addPost = function() {
      vm.posts.push({
        title: vm.newPost.title,
        author: vm.newPost.author,
        content: vm.newPost.content,
        image: URL.createObjectURL(vm.newPost.image),
        likes: 0,
        showComments: false,
        comments: []
      });
      vm.newPost = {};
    };
    
    vm.likePost = function(post) {
      post.likes++;
    };
    
    vm.toggleComments = function(post) {
      post.showComments = !post.showComments;
    };
    
    vm.addComment = function(post) {
      post.comments.push(vm.newComment);
      vm.newComment = '';
    };
  });
