import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";

const ProtectedRoute = (props) => {
  const authCheck = () => {
    const user = useSelector((state) => state.logins.logins);
    if (user.length > 0) {
      console.log(user);
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
