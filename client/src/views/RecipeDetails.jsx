import { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'

const RecipeDetails = () => {
    const navigate = useNavigate()
    const [recipe, setRecipe] = useState({})
    const { id } = useParams()
    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/${id}`)
            .then(res => {
                console.log(res)
                setRecipe(res.data)
            }
            )
            .catch(err => err);
    }, [id])

    return (
        <div className="recipe d-flex flex-column gap-5">
            <a href="/recipes" className="text-start">Back To DashBoard</a>
            <div>
                <div className="container-left">
                    <div className="recipeNames d-flex flex-row align-items-center gap-3">
                        <h1>{recipe.recipeName}</h1>
                        <img src="../images/icons8-edit-24.png" alt="edit me" onClick={() => { navigate(`/recipes/${id}/edit`) }} />
                        <img src="../images/icons8-delete-48.png" alt="delete me" onClick={() => { navigate(`/recipes/${id}/delete`) }} />
                    </div>
                    <p className="fs-3 text-start">Uploaded By User's FirstName</p>
                    <div className="d-flex flex-row gap-5">
                        <div>
                            <h3>Ingredients</h3>
                            <p>{recipe.ingredients}</p>
                        </div>
                        <div>
                            <h3>Cooking steps</h3>
                            <p>{recipe.cookingSteps}</p>
                        </div>
                    </div>
                </div>
                <div className="container-right mx-auto">
                    <img src={`data:image/png;base64,${recipe.photo.data}`} alt="food goes here" width="100" height="100" />
                </div>
            </div>
        </div>

    )
}
export default RecipeDetails;