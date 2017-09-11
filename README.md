# Machine-learning-using-HMM

In this problem, you will use an HMM to break a simple substitution
ciphertext message. For each HMM, train using 200 iterations of the
Baum-Welch re-estimation algorithm.

a) Obtain an English plaintext message consisting of 50,000 plaintext
characters, where the characters consist only of lower case a through z
(i.e., remove all punctuation and spaces, and convert all upper case
to lower case). Encrypt this plaintext using a Caesar’s cipher.

b) Train an HMM with N = 2 and M = 26 on your ciphetext from
part a). From the resulting B matrix, determine the ciphertext
letters that correspond to consonants and those that correspond to
vowels.

c) Generate a digraph frequency matrix A for English text, where aij is
the count of the number of times that letter i is followed by letter j.
Note that a is letter 0, b is letter 1, c is letter 2, and so on. This
matrix must be based on 1,000,000 characters where, as above, only
the 26 letters of the alphabet are used. Next, add 5 to each element
in your 26 ⇥ 26 matrix A. Finally, normalize your matrix A by
dividing each element by its row sum. The resulting matrix A will
be row stochastic, and it will not contain any 0 probabilities.

d) Train an HMM with N = M = 26, using the first 1000 characters of
ciphertext you generated in part a), where the A matrix is initialized
with the A matrix from part c). Also, in your HMM, do not reestimate
A. Use the final B matrix to determine a putative key
and give the fraction of putative key elements that match the actual
key (as a decimal, to four places). For example, if 22 of the 26 key
positions are correct, then your answer would be 22/26 = 0.8462.
