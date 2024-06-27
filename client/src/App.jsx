import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './views/Login.jsx'
import Register from './views/Register.jsx'
import Home from './views/Home.jsx'
import AddRecipe from './views/AddRecipe.jsx'
import RecipeDetails from './views/RecipeDetails.jsx'
import UpdateRecipe from './views/UpdateRecipe.jsx'
import DeleteRecipe from './components/DeleteRecipe.jsx'

function App() {


  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route path="/recipes" element={<Home />}></Route>
          <Route path="/recipes/add" element={<AddRecipe />}></Route>
          <Route path="/recipes/:id" element={<RecipeDetails />}></Route>
          <Route path="/recipes/:id/edit" element={<UpdateRecipe />}></Route>
          <Route path="/recipes/:id/delete" element={<DeleteRecipe />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App;
