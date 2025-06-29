CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
  p_loan_amount    IN NUMBER,
  p_interest_rate  IN NUMBER, 
  p_duration_years IN NUMBER
) RETURN NUMBER IS
  v_monthly_rate   NUMBER;
  v_num_payments   NUMBER;
  v_emi            NUMBER;
BEGIN
  v_monthly_rate := p_interest_rate / 12 / 100;
  v_num_payments := p_duration_years * 12;

  v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_num_payments) /
           (POWER(1 + v_monthly_rate, v_num_payments) - 1);

  RETURN ROUND(v_emi, 2);
END;
/
