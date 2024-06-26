import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import axios from 'axios'

const AddRecipe = () => {

    const [recipeName, setRecipeName] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState("");
    const [cookingSteps, setCookingSteps] = useState("");
    const handleRegistration = (e) => {
        e.preventDefault()
        // const newRecipe = {
        //     'recipeName': recipeName,
        //     'description': description,
        //     'ingredients': ingredients,
        //     'cookingSteps': cookingSteps
        // }
        axios.post('http://localhost:8080/recipes/add',
            {
                recipeName,
                description,
                ingredients,
                cookingSteps
            })
            .then(resp => {
                console.log(res)
                console.log("data request sent!")
                navigate("/recipes")
            })
            .catch(err => err);


    }
    return (
        <div className="add-recipe">
            <form onSubmit={handleRegistration}>
                <label>
                    <input type="text" onChange={(e) => (setRecipeName(e.target.value))} placeholder="Recipe Name"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setDescription(e.target.value))} placeholder="Description"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setIngredients(e.target.value))} placeholder="Ingredients"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setCookingSteps(e.target.value))} placeholder="Cooking Steps"></input>
                </label>
                <input type="submit" value="Add Recipe"></input>
            </form>
        </div >
    )
}
export default AddRecipe;