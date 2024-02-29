import { Navigate } from "react-router-dom";

const ProtectedRoute = (props) => {
  const authCheck = () => {
    if (localStorage.getItem("user") != null) {
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
