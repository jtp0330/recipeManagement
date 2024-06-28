import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import axios from 'axios'

const AddRecipe = () => {

    const navigate = useNavigate()
    const [recipeName, setRecipeName] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState("");
    const [cookingSteps, setCookingSteps] = useState("");
    const [recipePic, setRecipePic] = useState("");
    const handleAdd = (e) => {
        e.preventDefault()

        const recipeData = new FormData()
        recipeData.append('recipeName', recipeName)
        recipeData.append('description', description)
        recipeData.append('ingredients', ingredients)
        recipeData.append('cookingSteps', cookingSteps)
        recipeData.append('recipePic', recipePic)
        console.log(recipeData)
        axios.post('http://localhost:8080/recipes/add', recipeData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
            .then(resp => {
                console.log(resp)
                console.log("data request sent!")
                navigate("/recipes")
            })
            .catch(err => err);


    }
    return (
        <div className="add-recipe d-flex flex-column justify-content-center">
            <a href="/recipes" className="text-start">Back To DashBoard</a>
            <form onSubmit={handleAdd} className="d-flex flex-column justify-content-center align-items-center gap-3">
                <h1>Add your recipe Here!</h1>
                <label htmlFor="name" />
                <input type="text" id="name" onChange={(e) => (setRecipeName(e.target.value))} placeholder="Recipe Name"></input>
                <label htmlFor="description" />
                <input type="text" id="description" onChange={(e) => (setDescription(e.target.value))} placeholder="Description"></input>
                <label htmlFor="ingredients" />
                <input type="text" id="ingredients" onChange={(e) => (setIngredients(e.target.value))} placeholder="Ingredients"></input>
                <label htmlFor="steps" />
                <input type="text" id="steps" onChange={(e) => (setCookingSteps(e.target.value))} placeholder="Cooking Steps"></input>
                <label htmlFor="pic" />
                <input type="file" id="pic" onChange={(e) => {
                    setRecipePic(e.target.files[0])
                }} placeholder="Upload" />
                <input type="submit" value="Add Recipe"></input>
            </form>
        </div >
    )
}
export default AddRecipe;