public class ConvertResponse {
    private boolean success;
    private double result;
    private error error;

    private class error{
        private String message;

        public String getMessage() {
            return message;
        }
    }

    public String getErrorMessage(){
        return error.getMessage();
    }

    public boolean isSuccess() {
        return success;
    }


    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ConvertResponse{" +
                "success=" + success +
                ", result=" + result +
                '}';
    }
}
