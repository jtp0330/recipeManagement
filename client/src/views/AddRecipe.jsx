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
    //error messages
    const [nameError, setNameError] = useState("");
    const [descriptionError, setDescriptionError] = useState("");
    const [ingredientsError, setIngredientsError] = useState("");
    const [stepsError, setStepsError] = useState("");


    // const ToBase64 = (image) => {
    //     const image_blob = response.blob()
    //     const image_json = JSON.stringify(image);
    //     return btoa(image_json);
    // }
    const handleAdd = (e) => {
        e.preventDefault()

        //clear error states
        setNameError("")
        setDescriptionError("")
        setIngredientsError("")
        setStepsError("")

        const recipeData = new FormData()
        recipeData.append('recipeName', recipeName);
        recipeData.append('description',description);
        recipeData.append('ingredients',ingredients);
        recipeData.append('cookingSteps',cookingSteps);
        recipeData.append('recipePic', new Blob([recipePic], { type: 'application/octet-stream' }));

        console.log(recipeData)

        axios.post('http://localhost:8080/recipes/add',recipeData)
        .then(resp => {
            console.log(resp)
            console.log("data request sent!")
            navigate("/")
            // navigate("/recipes")

        }).catch(err => {
            //load validations into request
            console.log(err)
            let validations = err.response.data.errors ? err.response.data.errors : null;
            if (validations) {
                validations.forEach(error => {
                    if (error.includes('name')) {
                        setNameError(error)
                    }
                    if (error.includes('describe')) {
                        setDescriptionError(error)
                    }
                    if (error.includes('ingredients')) {
                        setIngredientsError(error)
                    }
                    if (error.includes('steps')) {
                        setStepsError(error)
                    }
                })
            }
        });


    }
    return (
        <div className="add-recipe d-flex flex-column justify-content-center">
            <a href="/" className="text-start">Back To Dashboard</a>
            {/* In case login-register is implemented */}
            {/* <a href="/recipes" className="text-start">Back To Dashboard</a> */}

            <form onSubmit={handleAdd} className="d-flex flex-column justify-content-center align-items-center gap-3">
                <h1>Add your recipe Here!</h1>
                <label htmlFor="name" />
                <input type="text" id="name" onChange={(e) => (setRecipeName(e.target.value))} placeholder="Recipe Name"></input>
                {
                    nameError ? <span style={{ color: 'red' }}>{nameError}</span> : ''
                }
                <label htmlFor="description" />
                <textarea rows="5" id="description" onChange={(e) => (setDescription(e.target.value))} placeholder="Description"></textarea>
                {
                    descriptionError ? <span style={{ color: 'red' }}>{descriptionError}</span> : ''
                }
                <label htmlFor="ingredients" />
                <textarea rows="5" id="ingredients" onChange={(e) => (setIngredients(e.target.value))} placeholder="Ingredients"></textarea>
                {
                    ingredientsError ? <span style={{ color: 'red' }}>{ingredientsError}</span> : ''
                }
                <label htmlFor="steps" />
                <textarea rows="5" id="steps" onChange={(e) => (setCookingSteps(e.target.value))} placeholder="Cooking Steps"></textarea>
                {
                    stepsError ? <span style={{ color: 'red' }}>{stepsError}</span> : ''
                }
                <label htmlFor="pic" />
                <input type="file" id="pic" onChange={(e) => {setRecipePic(e.target.files[0])}} placeholder="Upload" />
                <input type="submit" value="Add Recipe"></input>
            </form>
        </div >
    )
}
export default AddRecipe;