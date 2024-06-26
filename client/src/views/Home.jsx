import Recipe from '../components/Recipe.jsx'
import { useState, useEffect } from 'react'
import axios from 'axios'

const Home = () => {

    const [recipes, setRecipes] = useState([])

    useEffect(() => {
        axios.get("http://localhost:8080/recipes")
            .then(res => {
                console.log(res.data);
                setRecipes(res.data)
            })
            .catch(err => err);
    }, [])

    return (
        <div className="recipeHome">
            <div>
                <h1>Get Cooking, Test!</h1>
                <a href="/recipes/add">Add Recipe</a>
            </div>

            <ul>
                {recipes.map((recipe, index) => (
                    //pass id of specific recipe into onclick api request
                    <li key={index} >
                        <Recipe image="" recipeName={recipe.recipeName} />
                    </li>
                ))}
            </ul>
        </div>
    )
}
export default Home;