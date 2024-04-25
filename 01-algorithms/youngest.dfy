// This variant of the example shows how we can
// **prove** in Dafny that the implementation satisfies
// the specification of finding the youngs person.
method FindYoungestPerson(ages: array<int>)
  returns (youngestPerson: int)
  requires ages.Length > 0
  ensures 0 <= youngestPerson < ages.Length
  ensures smallest(ages, youngestPerson)
{
  youngestPerson := 0;
  var youngestAge := ages[youngestPerson];
  var i := 1;

  while i < ages.Length
    invariant 0 <= youngestPerson < i <= ages.Length
    invariant youngestAge == ages[youngestPerson]
    invariant smallestSoFar(ages, youngestPerson, i - 1)
  {
    if ages[i] < youngestAge {
      youngestPerson := i;
      youngestAge := ages[youngestPerson];
    }
    i := i + 1;
  }
}

predicate smallestSoFar(a: array<int>, smallest: int, consideredSoFar: int)
  requires 0 <= smallest <= consideredSoFar < a.Length
  reads a
{
  forall i :: 0 <= i <= consideredSoFar ==> a[smallest] <= a[i]
}

predicate smallest(a: array<int>, smallest: int)
  requires 0 <= smallest < a.Length
  reads a
{
  smallestSoFar(a, smallest, a.Length - 1)
}

method Main()
{
  var ages := new int[] [35, 21, 25, 55, 45, 26, 24, 21, 19, 33, 37, 65, 25];
  var youngest := FindYoungestPerson(ages);
  print "#", (youngest + 1), " is the youngest person with age ", ages[youngest];
}