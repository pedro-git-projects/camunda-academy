Model a Decision Requirements Diagram for the Camundanzia use case:

"In out car insurance policy, we want to multiply the base price with a risk factor.
The risk factor should be determined using DMN.
In general the risk factor depends on the drivers experience and on the car type.
We determine the car type only based on its price and power."

Model the Car type Decision Table for the Camundanzia use case:

The car type should be determined by the price and the power in the following way.

- If the price is higher than 200.000$, it should always be a "luxury car".
- If the price is lower than 5000$, it is always a "scrap car"
- For all other cars, if the power is more than 120HP, it is a "sports car" and if it is lower than 120HP, it is a "family car".

Model the Risk Factor Decision Table for the Camundanzia use case:

The risk factor should be determined based on the car type and the drivers experience:

- If the drivers experience is lower than or equal to 3 years or the car type is a
"luxury car", the factor will be 5.0.
Exercise use case
- If the car type is a "family car", the factor will be 2.0 if the driver's experience is longer than 3 years.
Solution
- For "sports cars" it will be 2.0 if the experience is higher than 5 years, if it is only more than 3 years, it will be 3.0.

- The risk factor for "scrap cars" is always 1.0 (even if the driver has no experience)
