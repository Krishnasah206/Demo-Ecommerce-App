import { useEffect, useState } from 'react';
import './App.css';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

const API_BASE = "http://localhost:8080";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [selectTerm, setSelectTerm] = useState('');
  const [sortOrder, setSortOrder] = useState('asc');

  useEffect(() => {

    fetch(`${API_BASE}/api/products`)
      .then(res => res.json())
      .then(setProducts)
      .catch(err => console.error('Error fetching products:', err));

    fetch(`${API_BASE}/api/categories`)
      .then(res => res.json())
      .then(setCategories)
      .catch(err => console.error('Error fetching categories:', err));
  }, []);



  const handleSearchChange = (e) => setSelectTerm(e.target.value);
  const handleSortChange = (e) => setSortOrder(e.target.value);
  const handleCategorySelect = (categoryId) =>
    setSelectedCategory(categoryId ? Number(categoryId) : null);

  const filteredProducts = products
    .filter(product =>
      (!selectedCategory || product.category.id === selectedCategory) &&
      (!selectTerm || product.name.toLowerCase().includes(selectTerm.toLowerCase()))
    )
    .sort((a, b) => sortOrder === 'asc' ? a.price - b.price : b.price - a.price);

  return (
    <div className="container py-4">
      <header className="mb-4 p-3 bg-light rounded shadow-sm sticky-top z-3">
        <h2 className="text-center mb-3">🛍️ Product Catalog</h2>
        <div className="row g-3 justify-content-center">
          <div className="col-md-4 col-sm-12">
            <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
          </div>
          <div className="col-md-3 col-sm-6">
            <input
              type="text"
              className="form-control"
              placeholder="Search by name..."
              onChange={handleSearchChange}
            />
          </div>
          <div className="col-md-3 col-sm-6">
            <select className="form-select" onChange={handleSortChange}>
              <option value="asc">Sort: Price Low to High</option>
              <option value="desc">Sort: Price High to Low</option>
            </select>
          </div>
        </div>
      </header>

      <main>
        {filteredProducts.length > 0 ? (
          <ProductList products={filteredProducts} />
        ) : (
          <div className="text-center text-muted mt-5">
            <i className="bi bi-box-seam" style={{ fontSize: '3rem' }}></i>
            <p className="mt-3">No products available.</p>
          </div>
        )}
      </main>
    </div>
  );
}

export default App;
