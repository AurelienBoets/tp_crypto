import React, { useState, useEffect } from "react";
import { Link, NavLink, Outlet, useNavigate } from "react-router-dom";

function App() {
  const storedEmail = localStorage.getItem("email");
  const storedPassword = localStorage.getItem("password");
  const [isLoggedIn, setIsLoggedIn] = useState(
    !!storedEmail && !!storedPassword
  );
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("password");
    setIsLoggedIn(false);
    navigate("/");
  };

  useEffect(() => {
    const storedEmail = localStorage.getItem("email");
    const storedPassword = localStorage.getItem("password");
    setIsLoggedIn(!!storedEmail && !!storedPassword);
  }, [localStorage.getItem("password"), localStorage.getItem("email")]);

  return (
    <div className="App">
      <header>
        <nav
          className="navbar navbar-expand-lg bg-body-tertiary"
          data-bs-theme="dark"
        >
          <div className="container-fluid">
            <Link className="navbar-brand" to="/">
              Crypto Pro
            </Link>
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <NavLink className="nav-link" to={`/`}>
                    Accueil
                  </NavLink>
                </li>
              </ul>
              <ul className="navbar-nav ml-auto">
                {isLoggedIn ? (
                  <li className="nav-item">
                    <button className="nav-link btn" onClick={handleLogout}>
                      Déconnexion
                    </button>
                  </li>
                ) : (
                  <li className="nav-item">
                    <Link className="nav-link" to="/login">
                      Connexion
                    </Link>
                  </li>
                )}
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <main className="container">
        <div className="row my-3">
          <div className="col-10 offset-1 rounded p-3 bg-dark text-light">
            <Outlet />
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;
