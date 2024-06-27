

const Recipe = (props) => {

    const { image, recipeName } = props;

    return (
        <div className="">
            <img src="" alt="`{recipeName}`" className="card-img-top" />
            <p className="fs-3">{recipeName}</p>
        </div>
    )
}
export default Recipe;