import Recipe from '../components/Recipe.jsx'
import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const Home = () => {

    const [recipes, setRecipes] = useState([])
    const navigate = useNavigate()
    useEffect(() => {
        axios.get("http://localhost:8080/recipes")
            .then(res => {
                console.log(res.data);
                setRecipes(res.data)
            })
            .catch(err => err);
    }, [])

    return (
        <div className="recipeHome d-flex flex-column gap-5">
            <div className="d-flex justify-content-between">
                <h1 className="fs-1">Get Cooking!</h1>
                <div className="d-flex flex-column gap-1 text-end">
                    <a href="/recipes/add">Add Recipe</a>
                    <a href="/">Logout</a>

                </div>
            </div>

            <ul className="list-unstyled list-group-horizontal d-flex flex-wrap gap-5">
                {recipes.map((recipe, index) => (
                    //pass id of specific recipe into onclick api request
                    <li key={index} onClick={() => { navigate(`/recipes/${recipe.id}`) }}>
                        <Recipe image={recipe.recipePic} recipeName={recipe.recipeName} />
                    </li>
                ))}
            </ul>
        </div>
    )
}
export default Home;