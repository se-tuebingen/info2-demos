// This example shows how in the Dafny language we
// can express pre/postconditions and invariants to
// safely access arrays.
method FindYoungestPerson(ages: array<int>)
  returns (youngestPerson: int)
  requires ages.Length > 0
  ensures 0 <= youngestPerson < ages.Length
{
  youngestPerson := 0;
  var youngestAge := ages[youngestPerson];
  var i := 1;

  while i < ages.Length
    invariant 0 <= youngestPerson < ages.Length
  {
    if ages[i] < youngestAge {
      youngestPerson := i;
      youngestAge := ages[youngestPerson];
    }
    i := i + 1;
  }
}

method Main()
{
  var ages := new int[] [35, 21, 25, 55, 45, 26, 24, 21, 19, 33, 37, 65, 25];
  var youngest := FindYoungestPerson(ages);
  print "#", (youngest + 1), " is the youngest person with age ", ages[youngest];
}
