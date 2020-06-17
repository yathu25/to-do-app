
const app = new Vue({
  el: '#app',
  data: {
    title: 'to-do list',
    newTodo: '',
    todos: []
  },
  methods: {
    addTodo() {
       
    fetch("http://localhost:8080/api/toDo", { 
      
    // Adding method type 
    method: "POST", 
      
    // Adding body or contents to send 
    body: JSON.stringify({
        title: this.newTodo,
        done: false
      }), 
      
    // Adding headers to the request 
    headers: { 
        "Content-type": "application/json; charset=UTF-8"
    } 
}) 
      this.todos.push({
        title: this.newTodo,
        done: false
      });
      this.newTodo = '';
    },
    removeTodo(todo) {
        const todoIndex = this.todos.indexOf(todo);
      this.todos.splice(todoIndex, 1);
        fetch("http://localhost:8080/api/toDo/delete", { 
      
    // Adding method type 
    method: "POST", 
      
    // Adding body or contents to send 
    body: JSON.stringify(this.todos), 
      
    // Adding headers to the request 
    headers: { 
        "Content-type": "application/json; charset=UTF-8"
    } 
}) 
     
    },
    allDone() {
        this.todos.forEach(todo => {
        todo.done = true;
        fetch("http://localhost:8080/api/toDo/updateMultiple", { 
      
    // Adding method type 
    method: "POST", 
      
    // Adding body or contents to send 
    body: JSON.stringify(this.todos), 
      
    // Adding headers to the request 
    headers: { 
        "Content-type": "application/json; charset=UTF-8"
    } 
}) 
      
      });
    },
    done(todo)
    {
        console.log(todo);
        fetch("http://localhost:8080/api/toDo/update", { 
      
    // Adding method type 
    method: "POST", 
      
    // Adding body or contents to send 
    body: JSON.stringify(this.todos), 
      
    // Adding headers to the request 
    headers: { 
        "Content-type": "application/json; charset=UTF-8"
    } 
}) 
       
        
    }
//    handler: function handler(event) {
//        
//    }
  },
  created: function() {
    
 //const proxyurl = "";
// window.addEventListener('beforeunload', this.leaving);
 const url = "http://localhost:8080/api/toDo";
 fetch(url)
  .then(function(response) { 
   
   return response.json();
 })
.then(myJson => {
   this.todos=myJson;
   console.log(myJson);
  
 });
},

 
  
});