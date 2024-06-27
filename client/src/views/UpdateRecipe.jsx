import { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'


const UpdateRecipe = () => {
    const navigate = useNavigate()
    const { id } = useParams()
    const [recipeName, setRecipeName] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState("");
    const [cookingSteps, setCookingSteps] = useState("");

    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/${id}`)
            .then(res => {
                console.log(res)
                setRecipeName(res.data.recipeName),
                    setDescription(res.data.description),
                    setIngredients(res.data.ingredients),
                    setCookingSteps(res.data.cookingSteps)
            }
            )
            .catch(err => err);
    }, [id])


    const handleUpdate = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/recipes/${id}/edit`,
            {
                recipeName,
                description,
                ingredients,
                cookingSteps
            })
            .then(res => {
                console.log(res.data)
                navigate("/recipes")
            }).catch(err => err);
    }

    return (
        <div className="update-recipe">
            <form onSubmit={handleUpdate}>
                <label>
                    <input type="text" onChange={(e) => (setRecipeName(e.target.value))} value={recipeName}></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setDescription(e.target.value))} value={description}></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setIngredients(e.target.value))} value={ingredients}></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setCookingSteps(e.target.value))} value={cookingSteps}></input>
                </label>
                <input type="submit" value="Edit"></input>
            </form>
        </div >
    )
}
export default UpdateRecipe;