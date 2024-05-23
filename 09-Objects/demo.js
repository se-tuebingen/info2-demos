// This is the books example translated to JavaScript.
// Here it is much easier to see how we can create individual objects
// and use them. While in Java this is not idiomatic, in JS this way
// of using objects is quite common.

var effectiveJava1 = {
  title: "Effective Java",
  author: "Joshua Bloch",
  isBorrowed: false,
  borrow: function() {
    if (this.isBorrowed)
      console.log("Cannot borrow book again: " + this.title);
    else
      this.isBorrowed = true;
  }
}

var effectiveJava2 = {
  title: "Effective Java",
  author: "Joshua Bloch",
  isBorrowed: false,
  borrow: function() {
    if (this.isBorrowed)
      console.log("Cannot borrow book again: " + this.title);
    else
      this.isBorrowed = true;
  }
}


effectiveJava1.borrow()

console.log(effectiveJava1)

console.log(effectiveJava2)

effectiveJava2.borrow()

console.log(effectiveJava2)

