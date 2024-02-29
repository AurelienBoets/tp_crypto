import { useRef } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { postConnexion } from "./LoginSlice";

const FormLogin = () => {
  const navigate = useNavigate();

  const emailRef = useRef();
  const passwordRef = useRef();
  const dispatch = useDispatch();

  const handleFormSubmit = (e) => {
    e.preventDefault();
    const email = emailRef.current.value;
    const password = passwordRef.current.value;
    dispatch(postConnexion({ email, password }))
      .then(() => {
        navigate("/Wallet");
      })
      .catch((error) => {
        console.log(error);
      });

    // localStorage.setItem("email", email);
    // localStorage.setItem("password", password);

    // navigate("/Wallet");
  };

  return (
    <form onSubmit={handleFormSubmit}>
      <h1>Authentification </h1>
      <hr />
      <div className="mb-3">
        <label htmlFor="email" className="form-label">
          Email
        </label>
        <input
          type="email"
          className="form-control"
          id="email"
          ref={emailRef}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">
          Password
        </label>
        <input
          type="text"
          className="form-control"
          id="password"
          ref={passwordRef}
        />
      </div>

      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
};

export default FormLogin;
