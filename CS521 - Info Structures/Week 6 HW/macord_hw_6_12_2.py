"""
Marcus Acord-Serventi
Class: CS 521 - Spring1 2021
Date: 2/26/2021
Homework Problem: 6.12.1
Description of Problem: Creating classes and subclasses (organ, heart, brain)
"""


class Organ():
    """Default organ class. Has attributes or name, weight in grams,
    vital organ, organ system, transplantable, and gender. Sub-functions to
    change the attributes."""

    def __init__(self, organ_name='default', organ_weight_grams=100,
                 is_vital_organ='is', organ_system='body',
                 is_transplantable='is not', organ_gender='none'):
        self.organ_name = organ_name
        self.organ_weight_grams = organ_weight_grams
        self.is_vital_organ = is_vital_organ
        self.organ_system = organ_system
        self.is_transplantable = is_transplantable
        self.organ_gender = organ_gender

    def __repr__(self):
        """Gives the attributes of the default organ."""
        return "This is an organ named {name} that weighs {weight} grams. " \
               "It {vital} a vital organ, is part of the {system}, " \
               "and {transplant} transplantable. Male/Female: It is found " \
               "in {gender}.".format(name=self.organ_name,
                                     weight=self.organ_weight_grams,
                                     vital=self.is_vital_organ,
                                     system=self.organ_system,
                                     transplant=self.is_transplantable,
                                     gender=self.organ_gender)

    # the following functions are not used, but kept for reference to change
    # attributes
    def set_weight_grams(self, weight):
        """Sets the weight of the organ in grams."""
        self.organ_weight_grams = weight
        return self

    def set_vital_organ(self, vital):
        """Sets whether the organ (is) or (is not) vital."""
        self.is_vital_organ = vital
        return self

    def set_organ_system(self, system):
        """Sets which system the organ is part of."""
        self.organ_system = system
        return self

    def set_is_transplantable(self, transplant):
        """Sets whether the organ (is) or (is not) transplantable."""
        self.is_transplantable = transplant
        return self

    def set_organ_gender(self, gender):
        """Sets the organ gender as Male, Female, or Both."""
        self.organ_gender = gender
        return self

    def __len__(self):
        """Returns the length of the name. Kept for reference."""
        return len(self.organ_name)


class Heart(Organ):
    """Heart class. Subclass of the Organ Class. Default attributes of
    heart length in cm, heart weight (gets from parent class by default),
    heart thickness, and heart breadth. Sub-functions to return the status and
    weight in ounces."""

    # organ weight, by default, is taken from the parent class (per HW instruct)
    def __init__(self, heart_length_cm=18,
                 heart_weight_grams=Organ().organ_weight_grams,
                 heart_thickness_cm=0.7, heart_breadth_cm=2):
        super().__init__(organ_name='heart',
                         is_vital_organ='is', organ_system='muscular',
                         is_transplantable='is', organ_gender='both')
        self.heart_length_cm = heart_length_cm
        self.heart_weight_grams = heart_weight_grams
        self.heart_thickness_cm = heart_thickness_cm
        self.heart_breadth_cm = heart_breadth_cm

    def __repr__(self):
        """Gives the heart specific attributes."""
        return "This is a heart. It is {length} cm long, weighs {weight} " \
               "grams, is {thickness} cm thick, and has a breadth " \
               "of {breadth} cm.".format(length=self.heart_length_cm,
                                         weight=self.heart_weight_grams,
                                         thickness=self.heart_thickness_cm,
                                         breadth=self.heart_breadth_cm)

    def heart_status(self):
        """ Returns heart status of 'pumping blood'."""
        return 'Pumping blood.'

    def heart_weight_oz(self):
        """Returns the heart weight in grams."""
        return self.heart_weight_grams * 0.035


class Brain(Organ):
    """Brain subclass of organ class. Has attributes of volume and weight
    (gets from parent class by default). Sub-functions to return status
    and weight in ounces."""

    # organ weight, by default, is taken from the parent class (per HW instruct)
    def __init__(self, brain_volume=100,
                 brain_weight_gram=Organ().organ_weight_grams):
        super().__init__(organ_name='brain',
                         is_vital_organ='is', organ_system='nervous',
                         is_transplantable='is not', organ_gender='male')
        self.brain_volume = brain_volume
        self.brain_weight_gram = brain_weight_gram

    def __repr__(self):
        """Gives heart specific attributes."""
        return "This is a brain. It has a volume of {volume} cm^3. It has " \
               "a weight of {weight} " \
               "grams.".format(volume=self.brain_volume,
                               weight=self.brain_weight_gram)

    def brain_status(self):
        """Returns brain status of 'Thinking'."""
        return 'Thinking'

    def brain_weight_oz(self):
        """Returns brain weight in ounces."""
        return self.brain_weight_gram * 0.035


if __name__ == '__main__':
    # instantiate a heart and print it
    my_heart = Heart(heart_length_cm=12, heart_weight_grams=280,
                     heart_thickness_cm=6.0, heart_breadth_cm=9.0)
    print(my_heart)

    # instantiate a brain and print it
    my_brain = Brain(brain_volume=1260, brain_weight_gram=1370.0)
    print(my_brain)

    # assert tests; check formula for weight, heart weight should make sense,
    # abd check to ensure heart passed is transplantable correctly
    assert my_brain.brain_weight_oz() == my_brain.brain_weight_gram * 0.035, \
        'Brain weight in ounces is incorrect. Check brain_weight_oz function.'
    assert my_heart.heart_weight_grams > 0, 'Heart weight cannot be 0 or less.'
    assert my_heart.is_transplantable == 'is', 'Heart did not pass attribute ' \
                                               'is transplantable to parent'
    print("\nAssert tests passed!\n")
    # testing all the attributes below, per the HW instructions
    print("Heart status: ", my_heart.heart_status())
    print("Heart weight in ounces: ", my_heart.heart_weight_oz())
    print("Brain status: ", my_brain.brain_status())
    print("Brain weight in ounces: ", my_brain.brain_weight_oz())

    print()

    # note, weight is gained from parent class, per HW instructions
    # which is why the organ weight looks weird
    print("Printing heart attributes: This is an organ named {name} "
          "than weighs {weight} grams. "
          "It {vital} a vital organ, is part of the {system} system, "
          "and {transplant} transplantable. Male/Female: It is found "
          "in {gender}.".format(name=my_heart.organ_name,
                                weight=my_heart.organ_weight_grams,
                                vital=my_heart.is_vital_organ,
                                system=my_heart.organ_system,
                                transplant=my_heart.is_transplantable,
                                gender=my_heart.organ_gender))
    print(my_heart.__repr__())

    # note, weight is gained from parent class, per HW instructions
    # which is why the organ weight looks weird
    print("Printing brain attributes: This is an organ named {name} "
          "than weighs {weight} grams. "
          "It {vital} a vital organ, is part of the {system} system, "
          "and {transplant} transplantable. Male/Female: It is found "
          "in {gender}.".format(name=my_brain.organ_name,
                                weight=my_brain.organ_weight_grams,
                                vital=my_brain.is_vital_organ,
                                system=my_brain.organ_system,
                                transplant=my_brain.is_transplantable,
                                gender=my_brain.organ_gender))
    print(my_brain.__repr__())

    print("\nUnit tests complete!")

"""Test case:

This is a heart. It is 12 cm long, weighs 280 grams, is 6.0 cm thick, and has a breadth of 9.0 cm.
This is a brain. It has a volume of 1260 cm^3. It has a weight of 1370.0 grams.

Assert tests passed!

Heart status:  Pumping blood.
Heart weight in ounces:  9.8
Brain status:  Thinking
Brain weight in ounces:  47.95

Printing heart attributes: This is an organ named heart than weighs 100 grams. It is a vital organ, is part of the muscular system, and is transplantable. Male/Female: It is found in both.
This is a heart. It is 12 cm long, weighs 280 grams, is 6.0 cm thick, and has a breadth of 9.0 cm.
Printing brain attributes: This is an organ named brain than weighs 100 grams. It is a vital organ, is part of the nervous system, and is not transplantable. Male/Female: It is found in male.
This is a brain. It has a volume of 1260 cm^3. It has a weight of 1370.0 grams.

Unit tests complete!

Process finished with exit code 0"""