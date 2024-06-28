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
        <div className="update-recipe d-flex flex-column justify-content-center">
            <a href="/recipes" className="text-start">Back To DashBoard</a>
            <form onSubmit={handleUpdate} className="d-flex flex-column justify-content-center align-items-center gap-3">
                <h1>Update your recipe Here!</h1>
                <label htmlFor="name" />
                <input type="text" id="name" onChange={(e) => (setRecipeName(e.target.value))} value={recipeName}></input>
                <label htmlFor="description" />
                <input type="text" id="description" onChange={(e) => (setDescription(e.target.value))} value={description}></input>
                <label htmlFor="ingredients" />
                <input type="text" id="ingredients" onChange={(e) => (setIngredients(e.target.value))} value={ingredients}></input>
                <label htmlFor="steps" />
                <input type="text" id="steps" onChange={(e) => (setCookingSteps(e.target.value))} value={cookingSteps}></input>
                {/* <input type="file" onChange={() => { }} /> */}
                <input type="submit" value="Edit"></input>
            </form>
        </div >
    )
}
export default UpdateRecipe;