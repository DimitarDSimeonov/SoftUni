function attachEvents() {
    let LOAD_URL = 'http://localhost:3030/jsonstore/blog/posts';
    let COMMENTS_URL = 'http://localhost:3030/jsonstore/blog/comments';
    let loadBtn = document.getElementById('btnLoadPosts');
    let select = document.getElementById('posts');
    let viewBtn = document.getElementById('btnViewPost');
    let postTitle = document.getElementById('post-title');
    let postBody = document.getElementById('post-body');
    let commentsList = document.getElementById('post-comments');

    loadBtn.addEventListener('click', loadPosts);
    viewBtn.addEventListener('click', loadComments);

    // commentsList.addEventListener('change', () => {
    //     postTitle.textContent = 'Post Details'
    //     postBody.textContent = ''
    // });

    let posts = [];

    function loadPosts() {
        
        fetch(LOAD_URL)
        .then((res) => res.json())
        .then((allPost) => {
            posts = Object.values(allPost);
                
            posts.forEach((p) => {
                let option = document.createElement('option');
                option.value = p.id;
                option.textContent = p.title;
                select.appendChild(option); 
            }) 
        })
        .catch((err) => {
            console.error(err);
        })
    }


    function loadComments() {
        commentsList.innerHTML = '';
        fetch(COMMENTS_URL)
        .then((res) => res.json())
        .then((data) => {
            let comments = Object.values(data);

            let selectedPost = select.options[select.selectedIndex].textContent;
            let post = posts.find((p) => p.title === selectedPost);
            console.log(post);
            postTitle.textContent = post.title;
            postBody.textContent = post.body;

            comments.forEach((c) => {
                if (c.postId === post.id ) {
                    let li = document.createElement('li');
                    li.textContent = c.text;
                    commentsList.appendChild(li);
                }
            })
        })
    }
}

attachEvents();