const ProductList = ({ products }) => {
  return (
    <div className="row">
      {products.map((product) => (
        <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={product.id}>
          <div className="card h-100 shadow-sm border-0 rounded-4">
            <img
              src={product.imageUrl || 'https://placehold.co/600x400'}
              className="card-img-top rounded-top-4"
              alt={product.name}
              style={{ objectFit: 'cover', height: '250px' }}
            />
            <div className="card-body d-flex flex-column justify-content-between">
              <div>
                <h5 className="card-title">{product.name}</h5>
                <p className="card-text text-muted" style={{ fontSize: '0.9rem' }}>
                  {product.description}
                </p>
              </div>
              <p className="card-text mt-auto">
                <strong className="text-primary">${product.price.toFixed(2)}</strong>
              </p>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
