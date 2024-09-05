function is_prime(n) {
    if (n < 2) return 0;
    for (i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) return 0;
    }
    return 1;
}

{
    if (is_prime($1)) {
        print $1 " is prime";
    }
}
