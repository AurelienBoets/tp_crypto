import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { postLogin } from "./LoginSlice";

const FormRegister = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const lastnameRef = useRef();
  const firstnameRef = useRef();
  const emailRef = useRef();
  const passwordRef = useRef();

  const handleFormSubmit = (e) => {
    e.preventDefault();
    const lastname = lastnameRef.current.value;
    const firstname = firstnameRef.current.value;
    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    dispatch(postLogin({ lastname, firstname, email, password }))
      .then(() => {
        navigate("/Wallet");
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <form onSubmit={handleFormSubmit}>
      <h1>Inscription</h1>
      <hr />
      <div className="mb-3">
        <label htmlFor="lastname" className="form-label">
          Lastname
        </label>
        <input
          type="text"
          className="form-control"
          id="lastname"
          ref={lastnameRef}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="firstname" className="form-label">
          Firstname
        </label>
        <input
          type="text"
          className="form-control"
          id="firstname"
          ref={firstnameRef}
        />
      </div>
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
          type="password"
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

export default FormRegister;
