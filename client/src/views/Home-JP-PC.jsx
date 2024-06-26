import Recipe from './RecipeDetails'


const Home = () => {

    const [recipes, setRecipes] = useState([])
    // useEffect(() => {
    fetch("http://localhost:8080/recipes")
        .then(data => setRecipes(data))
        .catch(err => err);
    // }

    // )

    return (
        <div className="recipeHome">
            <h1>Get Cooking, { }!</h1>

            <ul>
                <Recipe image="" recipeName="French Toast" />
            </ul>
        </div>
    )
}
export default Home;