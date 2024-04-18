import React from 'react';

function TodoList({ todos, completeTodo, removeTodo }) {
  return (
    <div>
      <h2>Todo List:</h2>
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            <span style={{ textDecoration: todo.isDone ? 'line-through' : 'none' }}>{todo.title}</span>
            {!todo.isDone && (
              <button onClick={() => completeTodo(todo.title)}>Complete</button>
            )}
            <button onClick={() => removeTodo(todo.title)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;
