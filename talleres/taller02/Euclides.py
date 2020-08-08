def gcd_euclid(p, q):
	m = p % q
	if m == 0:
		return q
	else:
		return gcd_euclid(q, m)

print(gcd_euclid(345, 150))
