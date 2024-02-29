import { Navigate } from "react-router-dom";

const ProtectedRoute = (props) => {
  const authCheck = () => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username === "email@gmail.com" && password === "password") {
      return true;
    } else {
      return false;
    }
  };
  if (authCheck()) {
    return <>{props.children}</>;
  } else {
    return <Navigate to={"/"}></Navigate>;
  }
};

export default ProtectedRoute;
