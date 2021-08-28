/*
 *  File Name:    App.java
 *  Project Name: ConsoleApp
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 28 Aug 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.two.console;

import com.bewsoftware.tafe.java3.at2.two.common.AvlTree;
import com.bewsoftware.tafe.java3.at2.two.common.MechanicalPart;
import com.bewsoftware.tafe.java3.at2.two.common.Ref;
import java.text.MessageFormat;

/**
 * This is the main class for the console application.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class App
{

    private static final String FRMT = "{0}: [Qty:{1,number,integer}], "
                                       + "[Cost:{2,number,currency}], "
                                       + "[TotalValue:{3,number,currency}]";

    private static final String FRMT2 = "{0}: [Cost:{1,number,currency}], "
                                        + "[Markup:{2,number,percent}], "
                                        + "[RetailPrice:{3,number,currency}]";

    private static final String LINE = "\n-------------------------------------------------------------------\n";

    private static final String[][] PARTS_LIST =
    {
        {
            "Washer (5mm)", "5mm diameter flat washer", "100", "0.10", "20.0"
        },
        {
            "Washer (10mm)", "10mm diameter flat washer", "100", "0.17", "20.0"
        },
        {
            "Nut and bolt (10mm)", "Hex head 10mm long bolt with nut", "100", "0.20", "20.0"
        },
        {
            "Nut and bolt (12mm)", "Hex head 12mm long bolt with nut", "100", "0.23", "20.0"
        },
        {
            "Water Pump (Ford Falcon 6cyl)", "Water pump for 6 cylinder engine in a Ford Falcon", "5", "55.00", "20.0"
        },
        {
            "Fan belt (Ford Falcon 6cyl)", "Fan belt for 6 cylinder engine in a Ford Falcon", "10", "10.00", "20.0"
        },
        {
            "Water Pump (Holden Comodore 6cyl)", "Water pump for 6 cylinder engine in a Holden Comodore", "5", "65.00", "20.0"
        },
        {
            "Fan belt (Holden Comodore 6cyl)", "Fan belt for 6 cylinder engine in a Holden Comodore", "10", "15.00", "20.0"
        },
        {
            "Spark plug (Type A)", "Type A spark plug", "10", "12.00", "20.0"
        },
        {
            "Spark plug (Type B)", "Type B spark plug", "10", "12.50", "20.0"
        },

    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        AvlTree<MechanicalPart> parts = new AvlTree<>();

        for (String[] partStrings : PARTS_LIST)
        {
            MechanicalPart part = new MechanicalPart(partStrings[0], partStrings[1], partStrings[2], partStrings[3], partStrings[4]);
            parts.add(part);
        }

        System.out.println(parts);
        System.out.println(LINE);
        System.out.println("Search: 'Nut and bolt (10mm)'\n");

        MechanicalPart part = new MechanicalPart("Nut and bolt (10mm)");
        MechanicalPart actual = null;

        if (parts.contains(part))
        {
            actual = parts.get(parts.indexOf(part));
            System.out.println(actual);
        }

        System.out.println(LINE);
        System.out.println("Remove: 'Nut and bolt (10mm)'\n");

        if (parts.remove(part))
        {
            System.out.println("Removed.");
        } else
        {
            System.out.println("Not removed!");
        }

        if (parts.contains(part))
        {
            System.out.println(parts.get(parts.indexOf(part)));
        } else
        {
            System.out.println("Not found!");
        }

        System.out.println(LINE);
        System.out.println("Add: 'Nut and bolt (10mm)'\n");

        if (parts.add(actual))
        {
            System.out.println("Part added.");
        } else
        {
            System.out.println("Part not added!");
        }

        System.out.println(LINE);
        System.out.println("Add again?: 'Nut and bolt (10mm)'\n");

        if (parts.add(actual))
        {
            System.out.println("Part added.");
        } else
        {
            System.out.println("Part not added!");
        }

        System.out.println(LINE);
        System.out.println(parts);

        System.out.println(LINE);

        final StringBuilder sb = new StringBuilder("Stock listing:\n\n");
        final Ref<Double> totalStockValue = new Ref<>(0.00);

        parts.forEach(fePart ->
        {
            String result = MessageFormat.format(FRMT, fePart.getName(), fePart.getQuantity(),
                                                 fePart.getCost(), fePart.totalValue());
            sb.append(result).append("]\n");
            totalStockValue.val += fePart.totalValue();
        });

        System.out.println(sb);

        System.out.println(MessageFormat.format("Total Stock Value: {0,number,currency}", totalStockValue.val));
        System.out.println(LINE);

        final StringBuilder sb2 = new StringBuilder("Retail Price listing:\n\n");
        parts.forEach(fePart ->
        {
            String result = MessageFormat.format(FRMT2, fePart.getName(), fePart.getCost(),
                                                 fePart.getMarkup() / 100, fePart.retailPrice());
            sb2.append(result).append("]\n");
        });

        System.out.println(sb2);

    }
}
