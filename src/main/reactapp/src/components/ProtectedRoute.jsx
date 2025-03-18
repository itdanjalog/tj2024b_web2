import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";

export default function ProtectedRoute({ children }) {
    const isAuthenticated = useSelector((state) => state.user.isAuthenticated);

    if (!isAuthenticated) {
        alert("로그인이 필요합니다.");
        return <Navigate to="/member/login" replace />;
    }

    return children;
}
