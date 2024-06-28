

const Recipe = (props) => {

    const { image, recipeName } = props;

    return (
        <div className="">
            <img src={`data:image/png;base64,${image}`} alt="food goes here" className="card-img-top" />
            <p className="fs-3">{recipeName}</p>
        </div>
    )
}
export default Recipe;