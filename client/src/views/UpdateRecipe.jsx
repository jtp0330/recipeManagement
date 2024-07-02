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
    const [recipePic, setRecipePic] = useState("");

    //error messages
    const [nameError, setNameError] = useState("");
    const [descriptionError, setDescriptionError] = useState("");
    const [ingredientsError, setIngredientsError] = useState("");
    const [stepsError, setStepsError] = useState("");

    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/${id}`)
            .then(res => {
                console.log(res)
                setRecipeName(res.data.recipeName)
                setDescription(res.data.description)
                setIngredients(res.data.ingredients)
                setCookingSteps(res.data.cookingSteps)
                setRecipePic(res.data.recipePic)
            }
            )
            .catch(err => err);
    }, [id])


    const handleUpdate = (e) => {
        e.preventDefault();


        //clear error states
        setNameError("")
        setDescriptionError("")
        setIngredientsError("")
        setStepsError("")

        const recipeData = new FormData()
        recipeData.append('recipeName', recipeName)
        recipeData.append('description', description)
        recipeData.append('ingredients', ingredients)
        recipeData.append('cookingSteps', cookingSteps)
        recipeData.append('recipePic', new Blob([recipePic], { type: 'application/octet-stream' }));


        axios.put(`http://localhost:8080/recipes/${id}/edit`,recipeData)
        .then(res => {
                console.log(res.data)
                // navigate("/recipes")
                navigate("/")

            }).catch(err => {
                //load validations into request
                
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
        <div className="update-recipe d-flex flex-column justify-content-center">
            
            <a href="/" className="text-start">Back To Dashboard</a>
            {/* In case login-register is implemented */}
            {/* <a href="/recipes" className="text-start">Back To Dashboard</a> */}

            <form onSubmit={handleUpdate} className="d-flex flex-column justify-content-center align-items-center gap-3">
                <h1>Update your recipe Here!</h1>
                <label htmlFor="name" />
                <input type="text" id="name" onChange={(e) => (setRecipeName(e.target.value))} value={recipeName}></input>
                {
                    nameError ? <span style={{ color: 'red' }}>{nameError}</span> : ''
                }
                <label htmlFor="description" />
                <textarea rows="5"  id="description" onChange={(e) => (setDescription(e.target.value))} value={description}></textarea>
                {
                    descriptionError ? <span style={{ color: 'red' }}>{descriptionError}</span> : ''
                }
                <label htmlFor="ingredients" />
                <textarea rows="5" id="ingredients" onChange={(e) => (setIngredients(e.target.value))} value={ingredients}></textarea>
                {
                    ingredientsError ? <span style={{ color: 'red' }}>{ingredientsError}</span> : ''
                }
                <label htmlFor="steps" />
                <textarea rows="5" id="steps"  onChange={(e) => (setCookingSteps(e.target.value))} value={cookingSteps}></textarea>
                {
                    stepsError ? <span style={{ color: 'red' }}>{stepsError}</span> : ''
                }
                <input type="file" id="pic" onChange={(e) => {
                    setRecipePic(e.target.files[0])
                }} placeholder="Upload" />
                <input type="submit" value="Edit"></input>
            </form>
        </div >
    )
}
export default UpdateRecipe;